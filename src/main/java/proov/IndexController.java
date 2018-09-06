package proov;

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

	@GetMapping("/")
	public String index() {
		downloadI.downloadsObservationsDTO();
		return "index.html";
	}
}
