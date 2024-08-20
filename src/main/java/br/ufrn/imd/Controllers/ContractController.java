package br.ufrn.imd.Controllers;
import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Exceptions.OwnerNotLoggedException;
import br.ufrn.imd.Models.Contract;

import java.io.IOException;
import java.util.List;

public class ContractController {

    FileManager fm = new FileManager();

    public List<Contract> getAllContracts() throws OwnerNotLoggedException, IOException {
        return fm.readOwnerLogged().getContracts();
    }
    public void saveContract(Contract contract) {
        List<Contract> contracts;
        try {
            contracts = getAllContracts();
            if (!contracts.contains(contract)) {
                contracts.add(contract);
            } else {
                contracts.remove(contract);
                contracts.add(contract);
            }
        } catch (OwnerNotLoggedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteContract(Contract contract) {
        List<Contract> contracts;
        try {
            contracts = getAllContracts();
            contracts.remove(contract);
        } catch (OwnerNotLoggedException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
