package nectia.com.echo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

@SpringBootApplication
@RestController
public class EchoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoApplication.class, args);
	} // end main

	@GetMapping("/")
	public Echo echo(@RequestHeader Map<String, String> headers,
							HttpServletRequest request) {
		return new Echo(LocalDateTime.now(), headers);
	} // end Echo echo(Map<String, String> headers, HttpServletRequest request)

	@AllArgsConstructor
	@Data
	private static class Echo {
		LocalDateTime timestamp;
		Map<String, String> headers;
	} // end static class Echo

} // end EchoApplication
