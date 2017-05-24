package xmu.mystore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "xmu.mystore" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
//@ImportResource("classpath*:flow-config.xml")
public class RootConfig {
}