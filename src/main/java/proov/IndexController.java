package proov;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import proov.interfaces.DownloadI;

@Slf4j
@Controller
public class IndexController {

	private final DownloadI downloadI;

	@Autowired
	public IndexController(DownloadI downloadI) {
		this.downloadI = downloadI;
	}

	@GetMapping("/") // @RequestMapping(value = "/")
	public String index() { // @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model
		//model.addAttribute("name", name);
		downloadI.downloadsObservationsDTO();
		return "index.html";
	}

	//	public public void main(String[] args) {
//		print(System.out);
//	}

	public static void print(PrintStream out) {
		out.print("Hello");
	}
}
