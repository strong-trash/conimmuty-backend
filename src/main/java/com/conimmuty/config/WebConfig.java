public class WebConfig {

}@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
//    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginArgumentResolver(jwtTokenProvider));
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("a")
                .allowedMethods("GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH".split(","))
                .allowedHeaders("Content-Type,Accept".split(","))
                .allowCredentials(true)
                .exposedHeaders(HttpHeaders.LOCATION);
    }
}
