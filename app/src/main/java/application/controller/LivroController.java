package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import application.repository.EditoraRepository;
import application.repository.LivroRepository;

@controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private GeneroRepository  generoRepo;
    @Autowired
    private EditoraRepository editoraRepo;

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        ui.addAttribute("editoras", editoraRepo.findAll());
        return "livro/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("genero") long idGenero,
        @RequestParam("editora") long idEditora
    ){
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setGenero(generoRepo.findById(idGenero).get());
        livro.setEditora(editoraRepo.fingById(idEditora).get());

        livroRepo.save(livro);
        return "redirect:/livros/list";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String list(Model ui){
        ui.addAttribute("livros", LivroRepo.findAll());

        return "redirect:/livros/list";

}