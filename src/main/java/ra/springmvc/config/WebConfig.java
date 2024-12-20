package ra.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// cấu hình các thành pần liên quan tới web
@Configuration // chú thích đây là lớp câu hình : tạo bean
@EnableWebMvc // sử dung mô hình MVC
@ComponentScan(basePackages = "ra.springmvc") // đánh dấu tất cả các lop component,controller, service, repository trong package ra.springmvc
// cấu hình các thành pần liên quan tới web (thêm vào trong Spring Boot)
public class WebConfig {
    // Bean
    // ViewResolver
    @Bean // tạo bean / singleton / tạo 1 đối tương
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // đư��ng d��n đến thư mục chứa các file view
        resolver.setSuffix(".jsp"); // đuôi mã của file view
        return resolver; // trả về bean ViewResolver đã cấu hình
    }
}
