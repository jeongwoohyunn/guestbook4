package com.douzone.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired//
	private GuestbookDao guestbookDao;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("list", guestbookDao.getList());
		return "index";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteform(
			@RequestParam(value="no", required=true) Long no) {
		return "delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestbookVo guestbookVo) {
		guestbookDao.delete(guestbookVo);
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo guestbookVo) {
		guestbookDao.insert(guestbookVo);
		return "redirect:/";
	}

}