package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class VendingMachineTest {
  @Test
  void init_vending_machine() {
    var vendingMachine = new VendingMachine();

    assertThat(vendingMachine.getReturnedCoins()).isEmpty();
  }
}
