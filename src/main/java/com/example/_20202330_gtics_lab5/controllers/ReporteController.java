package com.example._20202330_gtics_lab5.controllers;

import com.example._20202330_gtics_lab5.repositorys.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    final JobRepository jobRepository;

    public ReporteController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping({"","/"})
    public String primeraPagina(Model model){
        model.addAttribute("listaPedida",jobRepository.jobsDtoForReporte());
        return "reportes/salario";
    }

    @GetMapping("/tentativa")
    public String segundaPagina(){
        return "reportes/aumento";
    }

}
