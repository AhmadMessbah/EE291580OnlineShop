import com.mftplus.javaee04.model.entity.Invoice;
import com.mftplus.javaee04.model.entity.InvoiceItem;
import com.mftplus.javaee04.model.entity.Stuff;
import com.mftplus.javaee04.model.entity.User;
import com.mftplus.javaee04.model.entity.enums.InvoiceType;
import com.mftplus.javaee04.model.entity.enums.UserRole;
import com.mftplus.javaee04.model.service.InvoiceService;
import com.mftplus.javaee04.model.service.UserService;
import lombok.extern.log4j.Log4j;

@Log4j
public class JpaTest {
    public static void main(String[] args) throws Exception{
        User user =
                User
                        .builder()
                        .name("ahmad")
                        .family("messbah")
                        .username("ahmad")
                        .password("ahmad123")
                        .role(UserRole.Admin)
                        .build();
        System.out.println(UserService.getService().save(user));

        User user2 =
                User
                        .builder()
                        .name("ali")
                        .family("alipour")
                        .username("ali")
                        .password("ali123")
                        .role(UserRole.Customer)
                        .build();

        System.out.println(UserService.getService().save(user2));
        System.out.println(UserService.getService().findAll());

//        System.out.println(UserService.getService().findByUsername("ali"));
//        System.out.println(UserService.getService().findByUsername("reza"));
        System.out.println(UserService.getService().findByUsernameAndPassword("ali","ali123"));
        System.out.println(UserService.getService().findByUsernameAndPassword("ali","ali1234"));
    }



//    public static void main(String[] args) throws Exception {
//        User user =
//                User
//                        .builder()
//                        .name("ahmad")
//                        .family("messbah")
//                        .username("ahmad")
//                        .password("ahmad123")
//                        .role(UserRole.Admin)
//                        .build();
//UserService
//
//    User user2 =
//            User
//                    .builder()
//                    .name("ali")
//                    .family("alipour")
//                    .username("ali")
//                    .password("ali123")
//                    .role(UserRole.Customer)
//                    .build();

//
//        Stuff stuff1 = Stuff.builder().name("Mobile").build();
//        Stuff stuff2 = Stuff.builder().name("Laptop").build();
//        Stuff stuff3 = Stuff.builder().name("Speaker").build();
//
//        Invoice invoice =
//                Invoice
//                        .builder()
//                        .invoiceType(InvoiceType.Sell)
//                        .customer(user)
//                        .discount(50)
//                        .build();
//        invoice.addItem(InvoiceItem.builder().stuff(stuff1).count(5).price(1000).build());
//        invoice.addItem(InvoiceItem.builder().stuff(stuff3).count(2).price(200).build());
//
//        System.out.println(InvoiceService.getService().save(invoice));
//    }
}
