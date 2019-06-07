package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.mvc.entities.CommandeClient;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.IClientService;
import com.stock.mvc.services.ICommandeClientService;

@Controller
@RequestMapping(value="/commandeclient")
public class CommandeClientController {
	@Autowired
	private ICommandeClientService commandeClientService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IArticleService articleService;
	
	
	@RequestMapping(value="/")
	public String index(Model model) {
		List<CommandeClient> commandeclients= commandeClientService.selectAll();
		if(commandeclients.isEmpty()) {
			commandeclients= new ArrayList<CommandeClient>();
			model.addAttribute("commandeclients", commandeclients);
		}
		return"commandeclient/commandeclient";
	}

}
