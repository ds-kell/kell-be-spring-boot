package vn.com.dsk.demo.features.adapter.mockdata;

import vn.com.dsk.demo.features.adapter.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class MockDataGenerator {

    public static List<ProductDto> getMockProductList() {
        List<ProductDto> productList = new ArrayList<>();
        List<String> imageUrls = List.of(
                "//scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/515491609_1291258165694612_4121189862809021524_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeGmWcx875qqKNwuBAPwfMoj7S5LWJBG2_3tLktYkEbb_ZQYAxUa8JplG9I9ELdzvPIsEXoNJvcPBCPXcN_y2tRz&_nc_ohc=z5syCpNSd78Q7kNvwG3zrji&_nc_oc=AdkpoakUAIL_pg3heOzdgBc4O-SY9xYwkvdqksEnrRFnxY62JIkjK8PtbU8plIO5qgM&_nc_zt=23&_nc_ht=scontent.fhan5-11.fna&_nc_gid=16lda9wBaX92Co_w5G-Pmg&oh=00_AfWQvUBZDIpB2SMPFNiQaX6OEbBDqGp9ZThEdOgLApkWhg&oe=68961657",
                "//scontent.fhan5-9.fna.fbcdn.net/v/t39.30808-6/524638619_1291258222361273_3510264295637346104_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeGs7sK6HPpzhnBcXPvmc1WZWMgIjx0-MgxYyAiPHT4yDD79z4-NsUQomFSni1naK9tZPAJLMQnp3xdpWWtX022P&_nc_ohc=8M0pYcv2wj8Q7kNvwEUFT6B&_nc_oc=AdneoljrsNzmAw1uLcwQoyvp6d1FgSSkbUDlJpgAh6lsJHq5L-Mbt6wZtHlrh7EKLNI&_nc_zt=23&_nc_ht=scontent.fhan5-9.fna&_nc_gid=WPQFAh0MEbuYgi606m7Kew&oh=00_AfVaxkXu-YyA2NYm9HUSIJyTofdFMUGbH5LxG-DbzOIu7A&oe=68964CC5",
                "//scontent.fhan5-6.fna.fbcdn.net/v/t39.30808-6/524627384_1291258292361266_1196867590393611740_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeHKc9pS9wnA7SDm-YqMheDMthzNAwCxY1-2HM0DALFjXyJ86C1iXhgj3nfkT4LlPNU9ZMWY1izaHzViybLuc14L&_nc_ohc=fed3QRLUqu4Q7kNvwHaJtrG&_nc_oc=AdntVt2Cr978_FnbLXmUIieekh7Qpeu3zOMuA-yzTm-uCtDaOxdqxIFs7FYeMKZ0gEE&_nc_zt=23&_nc_ht=scontent.fhan5-6.fna&_nc_gid=MKWRc18CO3SOlJAvqLkG5w&oh=00_AfX0scCobjsb7-GQDiQv8nNt5eka73J68QZg0D1eoQSIDA&oe=6896338F",
                "//scontent.fhan5-6.fna.fbcdn.net/v/t39.30808-6/517690009_1291258375694591_5080740298231556804_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeEDeck4KNTjQvNUMR8ahC5ETFq7w8E17kBMWrvDwTXuQGhm6k3IdRlv7M8f2iq1ohW7sF9ynrZQHChoRoS6ZUPD&_nc_ohc=lYCGc45m5hsQ7kNvwFgDx5f&_nc_oc=AdnyKsrIOurRn1XRqC5Yrlc_RwDK_YLABtcHyYVPnD1mUxJXvruCEUnwBtnj6GfAz9M&_nc_zt=23&_nc_ht=scontent.fhan5-6.fna&_nc_gid=SkL-ptwmjhUcRGc0VROUYg&oh=00_AfX_dFHQRSfOTjrT8-QsTHjbznkPO50Zz3NjW365fW9t8w&oe=6896423D",
                "//scontent.fhan5-9.fna.fbcdn.net/v/t39.30808-6/524633039_1291257989027963_2161642625271531489_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeGEAZjtiKdwl_fG2tndsvQclAyupiUjBqWUDK6mJSMGpZTxcewWV8zWbU7TOKHNYAxSxsreleRuwwH0C73T-dWK&_nc_ohc=E15d9nNJT4YQ7kNvwF2HAVs&_nc_oc=AdmzzYBmAmQ8mev5pVYc68-3n4tIj2ZZFdUDpmfDbSnss7MtIhDMspJCQoLbwwfGaOw&_nc_zt=23&_nc_ht=scontent.fhan5-9.fna&_nc_gid=0xOXvbnryyyl3HuUhWbXyw&oh=00_AfXCV2IoxUrgaKz4aU_9naycgrrKoUhZF4200kk5ReOJ_Q&oe=68962464",
                "//scontent.fhan5-6.fna.fbcdn.net/v/t39.30808-6/524917650_1291258069027955_8343069680652450175_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeF7ynCsrKmbWRWxilQZmN92nTZLTcoGPjKdNktNygY-Mu_IyLtmRkeFT1vOK8B7SA57eCj7ZBKbBlzSKlKUb8md&_nc_ohc=t7MajMowqIIQ7kNvwF9KCNT&_nc_oc=AdnrXcWYqiJGyhkskSYAawe4sno2_5SUFIPIs9P8adTtzABs12NTWgjbt90XbDCRhtA&_nc_zt=23&_nc_ht=scontent.fhan5-6.fna&_nc_gid=8KVeg5u6AskgJYDXP-29Rg&oh=00_AfX9JfJdO1VtX_MrNDRxYb4KnWsL0Ovvb5HY-L4PXntHqA&oe=68962197",
                "//scontent.fhan5-8.fna.fbcdn.net/v/t39.30808-6/525115747_1291258032361292_7231771967745512581_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeFkpyzMx94t0D67eSetUObhRcRRw93GVANFxFHD3cZUA3o82u6lDLQZEWd-PFYJ4fD_R9OF635_UWS0bYcbvG_l&_nc_ohc=KLb-lxQ9snEQ7kNvwEtuQUo&_nc_oc=AdlSyEucItImf5AG4ydDdbmMFv5M815NpYiU__xSemX3w89WZvutAX7SM1aMSjI_P8I&_nc_zt=23&_nc_ht=scontent.fhan5-8.fna&_nc_gid=BISKClCDIqhKUar6gQaWaA&oh=00_AfVzWIc1d8FC4B1rZHZplkDOWNe0ohtdgn99QfaSTDeIug&oe=6896449D",
                "//scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-6/524990105_1291258125694616_8240532774084637152_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeHR1895Esw5arlEFAK0Mn8lt7tSpIS-Osy3u1KkhL46zBJ_FWibLRokudyaiU1E6JmuiFq2QmxxgO7hVPocmEXH&_nc_ohc=jVjSONWf9EoQ7kNvwEmUzky&_nc_oc=Adl8H1BacP40GjTNLvUAclKjKfXNXDjKiPr7dMqFbjvr-osjOWAeSic68_gDeOQlKPM&_nc_zt=23&_nc_ht=scontent.fhan5-2.fna&_nc_gid=-_nyOE5B8ELK7g2du8nhhA&oh=00_AfXsWqIwfNLw_aVvYuWgtb7yG9uYbNepQ4POedK2nT9Osg&oe=68963BB2"
                );
        for (int i = 1; i <= 50; i++) {
            ProductDto product = new ProductDto();
            product.setId((long) i);
            product.setTitle("Gift Card " + i);
            product.setHandle("gift-card-" + i);
            product.setDescription("This is a mock gift card " + i);
            product.setPublishedAt("2025-08-01T03:02:54-04:00");
            product.setCreatedAt("2025-08-01T03:02:53-04:00");
            product.setVendor("Mock Vendor " + i);
            product.setType("giftcard");
            product.setTags(Collections.emptyList());
            product.setPrice(1000L * i);
            product.setPriceMin(1000L * i);
            product.setPriceMax(10000L);
            product.setAvailable(true);
            product.setPriceVaries(true);
            product.setCompareAtPrice(null);
            product.setCompareAtPriceMin(0L);
            product.setCompareAtPriceMax(0L);
            product.setCompareAtPriceVaries(false);
            product.setOptions(Collections.singletonList("Denominations"));
            product.setRequiresSellingPlan(false);
            product.setSellingPlanGroups(Collections.emptyList());
            product.setContent("This is a mock gift card content for product " + i);

            int randomIndex = ThreadLocalRandom.current().nextInt(0, imageUrls.size());
            product.setFeaturedImage(imageUrls.get(randomIndex));
            product.setImages(imageUrls);

            // Mock media
            MediaDto media = new MediaDto();
            media.setAlt("Mock Gift Card Image " + i);
            media.setId((long) (1000 + i));
            media.setPosition(1);
            media.setAspectRatio(1.0);
            media.setHeight(2881);
            media.setWidth(2881);
            media.setMediaType("image");
            media.setSrc(imageUrls.get(randomIndex));

            PreviewImageDto previewImage = new PreviewImageDto();
            previewImage.setAspectRatio(1.0);
            previewImage.setHeight(2881);
            previewImage.setWidth(2881);
            previewImage.setSrc(imageUrls.get(randomIndex));

            media.setPreviewImage(previewImage);
            product.setMedia(Collections.singletonList(media));

            // Mock variants
            List<VariantDto> variants = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                VariantDto variant = new VariantDto();
                variant.setId((long) (i * 100 + j));
                variant.setTitle("$" + (j * 10));
                variant.setOption1("$" + (j * 10));
                variant.setOption2(null);
                variant.setOption3(null);
                variant.setSku(UUID.randomUUID().toString());
                variant.setRequiresShipping(false);
                variant.setTaxable(false);
                variant.setFeaturedImage(null);
                variant.setAvailable(true);
                variant.setName("Gift Card - $" + (j * 10));
                variant.setPublicTitle("$" + (j * 10));
                variant.setOptions(Collections.singletonList("$" + (j * 10)));
                variant.setPrice(1000L * j);
                variant.setWeight(0);
                variant.setCompareAtPrice(null);
                variant.setInventoryManagement(null);
                variant.setBarcode(null);
                variant.setRequiresSellingPlan(false);
                variant.setSellingPlanAllocations(Collections.emptyList());

                QuantityRuleDto rule = new QuantityRuleDto();
                rule.setMin(1);
                rule.setMax(null);
                rule.setIncrement(1);

                variant.setQuantityRule(rule);
                variants.add(variant);
            }
            product.setVariants(variants);

            productList.add(product);
        }

        return productList;
    }
}
