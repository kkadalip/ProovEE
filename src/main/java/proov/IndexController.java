package proov;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import proov.model.Observations;
import proov.model.Station;

@Slf4j
@Controller
public class IndexController {

	@Value("${download.url}")
	private String downloadURL;

	@Value("${download.offline-sample-instead}")
	private boolean downloadOfflineSampleInstead;

	@GetMapping("/")
	public String showHomePage() { // @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model
		//model.addAttribute("name", name);
		log.info("starting download");
		Observations observations = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Observations.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			if (downloadOfflineSampleInstead) {
				String pathToFile = "src/main/resources/static/observations_offline.xml";
				log.info("download url is " + pathToFile);
				observations = (Observations) jaxbUnmarshaller.unmarshal(new File(pathToFile));
			} else {
				log.info("download url is " + downloadURL);
				observations = (Observations) jaxbUnmarshaller.unmarshal(new URL(downloadURL));
			}
		} catch (JAXBException e) {
			log.error("jaxb failed", e);
		} catch (MalformedURLException e) {
			log.error("downloadURL failed", e);
		}
		log.info("download finished");

		if (observations != null) {
			log.info("Observations timestamp: " + observations.getTimestamp());
			for (Station station : observations.getStations()) {
				log.info(String.valueOf(station));
			}
		} else {
			log.error("observations is null");
		}
		return "index.html"; //"/WEB-INF/jsp/index.html";
	}

	//	public public void main(String[] args) {
//		print(System.out);
//	}

	public static void print(PrintStream out) {
		out.print("Hello");
	}
}
