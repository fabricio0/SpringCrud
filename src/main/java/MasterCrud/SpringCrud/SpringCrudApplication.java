package MasterCrud.SpringCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = MasterCrud.SpringCrud.repository.UsuarioRepository.class)
@ComponentScan(basePackageClasses = {MasterCrud.SpringCrud.controller.UserController.class, MasterCrud.SpringCrud.IndexController.class})
@EntityScan(basePackageClasses = MasterCrud.SpringCrud.util.Usuario.class)
@SpringBootApplication
@EnableTransactionManagement
public class SpringCrudApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/login.html");
		registry.setOrder(Ordered.LOWEST_PRECEDENCE);
	}

}
