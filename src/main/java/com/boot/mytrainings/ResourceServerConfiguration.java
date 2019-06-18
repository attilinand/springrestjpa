package com.boot.mytrainings;

//@EnableResourceServer
//@RestController
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
//{
//	  @RequestMapping("/public")
//	  public String publico() {
//	    return "You are inside public page no authentication required";
//	  }
//	  @RequestMapping("/private")
//	  public String privada() {
//	    return "You are inside authenticated private page";
//	  }
//	  @RequestMapping("/admin")
//	  public String admin() {
//	    return "you are inside authenticated Administrator page";
//	  }
//	  @Override
//		public void configure(HttpSecurity http) throws Exception {
//			http
//			.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/public").permitAll();
////			 .anyRequest().authenticated();
//			http.requestMatchers().antMatchers("/private")
//			.and().authorizeRequests()
//			.antMatchers("/private").access("hasRole('USER')")
//			.and().requestMatchers().antMatchers("/admin")
//			.and().authorizeRequests()
//			.antMatchers("/admin").access("hasRole('ADMIN')");
//		}   

//}

