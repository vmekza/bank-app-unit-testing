import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AccountTest.class,
    ATMTest.class,
    BankTest.class,
    BranchTest.class,
    CustomerTest.class,
    EmployeeTest.class,
    LoanTest.class,
    LoanAnalysisToolTest.class,
    TransactionTest.class,
    TransactionLogTest.class
})

public class AllTestsSuite {

}
