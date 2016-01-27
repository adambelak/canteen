package com.epam.training.canteen.menu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.epam.training.canteen.menu.converter", 
	"com.epam.training.canteen.menu.service", "com.epam.training.canteen.menu.web.transform"})
public class MenuConfiguration {

}
