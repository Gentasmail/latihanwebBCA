package com.bcaf.latihanweb.controller;

import com.bcaf.latihanweb.model.Mahasiswa;
import com.bcaf.latihanweb.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MahasiswaController {

    @Autowired
    private MahasiswaRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listMahasiswa", repo.findAll());
        return "mahasiswa";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Mahasiswa mahasiswa) {
        repo.save(mahasiswa);
        return "redirect:/";
    }
}
