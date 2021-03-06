package controller;

import model.ChainPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordChainController {

    private ChainPath chainPath = new ChainPath();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexView() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String findChainPath(@RequestParam("startWord") CharSequence startWord,
                                @RequestParam("endWord") CharSequence endWord) {

        chainPath = new ChainPath(
                startWord,
                endWord
        );
        return "result";
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("chainPath", chainPath);
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String resultPostView(@ModelAttribute ChainPath chainPath) {
        WordChain wordChain = new WordChain();
        wordChain.handleSearchWordChain(chainPath);
        return "result";
    }

}
