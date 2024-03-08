package kr.co.seoulit.erp.account.sys.common.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("prod")
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi group_posting() { //posting 그룹
        List<Tag> tags = List.of(
                new Tag().name("AssetManagementController").description("<b>[posting/ledger]</b> 자산관리대장 API"),
                new Tag().name("CashJournalController").description("<b>[posting/ledger]</b> 현금출납장 API"),
                new Tag().name("CustomerLedgerController").description("<b>[posting/ledger]</b> 거래처원장 API"),
                new Tag().name("JournalEntryController").description("<b>[posting/ledger]</b> 분개장 API"),
                new Tag().name("TotalCashJournalController").description("<b>[posting/ledger]</b> 총계정원장 API")
        );

        return GroupedOpenApi.builder()
                .group("posting")
                .pathsToMatch("/posting/**")
                .addOpenApiCustomiser(openApi -> {
                    openApi.setTags(tags);
                })
                .build();
    }

    //    @Bean
//    public GroupedOpenApi group2(){
//        String[] pathsToMatch={"/customer/**"};
//        String[] pathsToExclude={"/customer/mypage/**","/customer/login/**"};
//
//        return GroupedOpenApi.builder()
//                .group("customer")
//                .pathsToMatch(pathsToMatch) //group에 포함시킬 paths
//                .pathsToExclude(pathsToExclude) //group에서 제외시킬 paths
//                .build();
//    }
//
    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Account 76")
                .description("Swagger API")
                .version("v.1.0"));
    }
}