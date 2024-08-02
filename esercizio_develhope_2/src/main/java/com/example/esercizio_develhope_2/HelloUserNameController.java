package com.example.esercizio_develhope_2;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class HelloUserNameController {
    @GetMapping(path = "/ciao/{provincia}")
    public UserName greet(
            @PathVariable String provincia,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "saluto", required = false, defaultValue = "") String saluto
    ) {
        if (saluto.isEmpty()) {
            saluto = "Ciao " + nome + ", com'è il tempo in " + provincia + "?";
        }
        return new UserName(nome, provincia, saluto);

    }

}
