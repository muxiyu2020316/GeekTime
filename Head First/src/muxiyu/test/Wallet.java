package muxiyu.test;
import java.math.BigDecimal;
public class Wallet {
    private String id;//唯一编号
    private long createTime;//创建的时间
    private BigDecimal balance;//钱包中的余额
    private long balanceLastModifiedTime;//上次钱包余额变更的时间
    // ...省略其他属性...

    public Wallet() {
       // this.id = IdGenerator.getInstance().generate();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    // 注意：下面对get方法做了代码折叠，是为了减少代码所占文章的篇幅
    public String getId() { return this.id; }
    public long getCreateTime() { return this.createTime; }
    public BigDecimal getBalance() { return this.balance; }
    public long getBalanceLastModifiedTime() { return this.balanceLastModifiedTime;  }

    /**
     * 增加
     * @param increasedAmount
     */
    public void increaseBalance(BigDecimal increasedAmount) {
        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
           // throw new InvalidAmountException("...");
        }
        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    /**
     * 减少
     * @param decreasedAmount
     */
    public void decreaseBalance(BigDecimal decreasedAmount) {
        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
           // throw new InvalidAmountException("...");
        }
        if (decreasedAmount.compareTo(this.balance) > 0) {
           // throw new InsufficientAmountException("...");
        }
        this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}
