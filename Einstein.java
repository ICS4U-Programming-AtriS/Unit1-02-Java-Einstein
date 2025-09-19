import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program that calculates the energy of an object.
 * Given the mass value [in kg],
 * It will calculate the energy using Einstein's equation.
 *
 * @author Atri Sarker
 * @version 1.0
 * @since 2025-09-19
 */
public final class Einstein {
  /**
   * Private constructor to satisfy style checker.
   *
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private Einstein() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Constant that defines the speed of light in m/s
   * Defined with precision up to 2.998 due to instructions.
   */
  public static final double SPEED_OF_LIGHT = 2.998e8;

  /**
   * Entrypoint of the program.
   *
   * @param args UNUSED.
   */
  public static void main(final String[] args) {
    // Prompt for mass.
    System.out.print("Enter the mass of the object [kg]: ");
    // Initialize Scanner for user input.
    final Scanner scanner = new Scanner(System.in);
    // TRY CATCH
    try {
      // Read mass as a double.
      final double mass = scanner.nextDouble();
      // Close scanner
      scanner.close();

      // Check if the mass is non-negative
      if (mass >= 0) {
        // Calculate Energy using Einstein's equation [e = m(c^2)]
        final double energy = mass * Math.pow(SPEED_OF_LIGHT, 2);
        // Display the result formatted to 3 decimal places. [IN BLUE]
        // %.3e for scientific notation with 4 significant figures.
        System.out.printf("\033[0;34mEnergy of the object: %.3e J", energy);
        System.out.println("");
      } else {
        // Error message for negative mass. [IN RED]
        System.out.println("\033[0;31mSorry, we don't support negativity.");
      }
    } catch (InputMismatchException error) {
      // Error message for non-numeric radius. [IN RED]
      System.out.println("\033[0;31mERROR: MASS VALUE MUST BE NUMERIC");
    }
  }
}
