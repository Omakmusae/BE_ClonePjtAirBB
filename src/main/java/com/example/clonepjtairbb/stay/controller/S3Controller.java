package com.example.clonepjtairbb.stay.controller;

import com.example.clonepjtairbb.common.utils.Message;
import com.example.clonepjtairbb.common.utils.S3Util;
import com.example.clonepjtairbb.stay.entity.ImageStorage;
import com.example.clonepjtairbb.stay.repository.ImageStorageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class S3Controller {
    private final S3Util s3Util;
    private final ImageStorageRepository imageStorageRepository;
//    private final ImageUrl imageUrl;
    @PostMapping("/api/stay/imageUrl")
    public ResponseEntity<Message> upLoadImage(@RequestPart(value = "img") List<MultipartFile> fileList){
        log.info("일단 메서드는 된다");
        List<String> imgUrlList = s3Util.uploadImg(fileList);
        for(String url : imgUrlList){
            imageStorageRepository.save(new ImageStorage(url));
        }
        return new ResponseEntity<>(new Message("이미지 저장완료"), HttpStatus.OK);
    }
}
