package com.example.ecommerceapplication.Config;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;
import java.util.Map;

public class CloudinaryConfig {

    public String insert(MultipartFile file, String name) throws IOException {
            HashMap<String,String> config = new HashMap<>();
             config.put("cloud_name", "dk3isulvu");
             config.put("api_key", "769296522985875");
             config.put("api_secret", "FkCtJe8NAQn7MJb7llXp4gqJI0A");
            Cloudinary cloudinary = new Cloudinary(config);
            Map<String, String> options = new HashMap<>();
            options.put("public_id", name);
            cloudinary.uploader().upload(file.getBytes(), options);

            String url = cloudinary.url().transformation(new Transformation().width(150).height(200).crop("fill")).generate(name);
            System.out.println(url);
            return url;

        }

    }