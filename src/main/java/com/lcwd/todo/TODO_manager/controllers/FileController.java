package com.lcwd.todo.TODO_manager.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {
    Logger logger= LoggerFactory.getLogger(FileController.class);

    @PostMapping("/single")
    public void getFile(@RequestParam("file")MultipartFile fle){
        logger.info("Name: {}",fle.getOriginalFilename());
        logger.info("File Type: {}",fle.getName());
        logger.info("File Size: {}",fle.getSize());
    }

    @PostMapping("/multiple")
    public void get_multiple_file(@RequestParam("files") MultipartFile[] fle){
        Arrays.stream(fle).forEach(curr_fle->{
            logger.info("File Name: {}",curr_fle.getOriginalFilename());
            logger.info("File Size {}",curr_fle.getSize());
        });
    }

    // Sending File as Response
    @GetMapping("/download")
    public void serve_file(HttpServletResponse response){
        try{
            InputStream file_input_stream=new FileInputStream("images/sunset-silhouettes-trees-mountains-generative-ai.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(file_input_stream,response.getOutputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
