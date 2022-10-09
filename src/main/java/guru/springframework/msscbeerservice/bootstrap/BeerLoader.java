package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {
  private final BeerRepository beerRepository;

  @Autowired
  public BeerLoader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() > 0) return;

    beerRepository.save(Beer.builder()
        .beerName("Mongo Bobs")
        .beerStyle("IPA")
        .upc(2353464357L)
        .quantityToBrew(200)
        .minOnHand(1)
        .price(new BigDecimal("12.95"))
        .build());

    beerRepository.save(Beer.builder()
        .beerName("Galaxy Cat")
        .beerStyle("PALE_ALE")
        .upc(132346407L)
        .quantityToBrew(200)
        .minOnHand(1)
        .price(new BigDecimal("10.95"))
        .build());

    System.out.println("Loaded Beers: " + beerRepository.count());
  }
}
