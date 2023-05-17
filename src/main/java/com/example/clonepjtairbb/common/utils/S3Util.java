package com.example.clonepjtairbb.common.utils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Util {
    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    // 업로드
    public String uploadImg(MultipartFile file){
        // file의 이름을 unique하게 만드는 방법
        String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
        File fileObj = convertMultiPartFileToFile(file);
        // 버킷에 파일 등록 parameter(bucketname, filename, file)
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, fileObj));
        //버켓으로부터 해당 파일의 url 반환 >> IMG Entity에 저장하기 위한 목적
        String imgURL = amazonS3Client.getUrl(bucket, fileName).toString();
        // 파일을 버켓에 넣고나서도 존재하기 때문에 버켓에 등록 후에는 삭제해주는걸 권장한다고 한다.
        fileObj.delete();
        return imgURL;
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
