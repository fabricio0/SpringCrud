package MasterCrud.SpringCrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	public IndexController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/")
	public String Index() {
		return "index";
	}
}
