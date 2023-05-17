package com.example.clonepjtairbb.common.utils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.example.clonepjtairbb.stay.entity.ImageStorage;
import com.example.clonepjtairbb.stay.repository.ImageStorageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Util {
    private final ImageStorageRepository imageStorageRepository;
    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    // 업로드
    public List<String> uploadImg(List<MultipartFile> fileList){
        List<String> imgUrlList = new ArrayList<>();
        for(MultipartFile file : fileList){
            String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();  // file의 이름을 unique하게 만드는 방법
            File fileObj = convertMultiPartFileToFile(file);
            amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, fileObj));  // 버킷에 파일 등록 parameter(bucketname, filename, file)
            imgUrlList.add(amazonS3Client.getUrl(bucket, fileName).toString());         //버켓으로부터 해당 파일의 url 반환 >> IMG Entity에 저장하기 위한 목적
            fileObj.delete();                               // 파일을 버켓에 넣고나서도 존재하기 때문에 버켓에 등록 후에는 삭제해주는걸 권장한다고 한다.
        }
        return imgUrlList;
    }

    // 다운로드
    public byte[] downloadFile(String fileName){
        S3Object s3Obj = amazonS3Client.getObject(bucket, fileName);
        S3ObjectInputStream inputStream = s3Obj.getObjectContent();

        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Convert
    private File convertMultiPartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}
