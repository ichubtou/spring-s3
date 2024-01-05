package com.ichubtou.s3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final S3ImageUploader s3ImageUploader;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        String imageUrl = s3ImageUploader.saveImage(multipartFile);

        return new ResponseEntity<>(imageUrl, HttpStatus.OK);
    }
}
