package com.senecafoundation;
import com.senecafoundation.NPCTypes.NPC;

import com.senecafoundation.DataHandler.RepoDataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("Npc")
public class NPCController 
{
        @Autowired
        RepoDataHandler dataHandler;
        
        @GetMapping("/createform")
        public String showForm(Model model) {
            NPC npc = new NPC();
            model.addAttribute("Npc", npc);
            return "create_Npc";
        }
    
        @RequestMapping(value = "/createform", method = RequestMethod.POST)
        public String submit(@ModelAttribute("Npc") NPC npc, BindingResult result, ModelMap model) {
            if (result.hasErrors()) {
                return "error";
            }
            dataHandler.Create(npc);
            //repo.save(shadowElf);
            model.addAttribute("Npc", npc);
            return "Npc";
        }
     
}