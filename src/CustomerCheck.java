import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double totalPrice = 0.0;
        for(MenuItem sum : check)
        {
            totalPrice += sum.getPrice();
        }
        return totalPrice;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        for (MenuItem items : check)
        {
            if (items.isDailySpecial())
            {
                return false;
            }
        }
        if (totalPrices() < 40)
        {
            return false;
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double newPrice = totalPrices();
        int customer = 0;
        double discount = 0;
        double tip = 0;
        for (MenuItem entree : check)
        {
            if (entree.isEntree())
            {
                customer++;
            }
        }
        if (couponApplies())
        {
            discount = newPrice * 0.25;
        }
        if (customer >= 6)
        {
            tip = newPrice  * 0.2;
        }
    }
}