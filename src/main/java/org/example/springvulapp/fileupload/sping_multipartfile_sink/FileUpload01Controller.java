package org.example.springvulapp.fileupload.sping_multipartfile_sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/FileUpload")

public class FileUpload01Controller {
    @GetMapping("/upload01")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload01")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()) {
            model.addAttribute("message", "❌ Please select a file to upload.");
            return "upload";
        }

        // ❌ VULNERABLE: No validation (chỉ để demo)
        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File destinationFile = new File(uploadDir + file.getOriginalFilename());

        // Đảm bảo thư mục tồn tại
        destinationFile.getParentFile().mkdirs();
        file.transferTo(destinationFile);

        model.addAttribute("message", "✅ File uploaded to: " + destinationFile.getAbsolutePath());
        return "upload";  // quay lại upload.html với thông báo
    }
}
