package org.satran.blockchain.graphql.resolvers;

import org.satran.blockchain.graphql.exception.DataFetchingException;
import org.satran.blockchain.graphql.model.Account;
import org.satran.blockchain.graphql.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletResolver {

    private static final Logger logger = LoggerFactory.getLogger(WalletResolver.class);

    private WalletService walletService;

    public WalletResolver(WalletService walletService) {
        this.walletService = walletService;
    }

    //Wallet get apis
    public List<String> addresses() {
        try {
            return walletService.getAddresses();
        } catch(Exception e) {
            logger.error("Error getting wallet accounts");
            throw new DataFetchingException(e.getMessage());
        }
    }

    public List<Account> accounts() {
        try {
            return walletService.getAccounts();
        } catch(Exception e) {
            logger.error("Error getting wallet accounts");
            throw new DataFetchingException(e.getMessage());
        }
    }

    public Account defaultAccount() {
        try {
            return walletService.getDefaultAccount();
        } catch(Exception e) {
            logger.error("Error getting wallet default account");
            throw new DataFetchingException(e.getMessage());
        }
    }

    public Account getMinerAccount() {
        try {
            return walletService.getMinerAccount();
        } catch(Exception e) {
            logger.error("Error getting wallet miner account");
            throw new DataFetchingException(e.getMessage());
        }
    }

}
