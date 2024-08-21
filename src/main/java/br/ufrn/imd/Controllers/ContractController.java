package br.ufrn.imd.Controllers;
import br.ufrn.imd.Dao.FileManager;
import br.ufrn.imd.Exceptions.OwnerNotLoggedException;
import br.ufrn.imd.Models.Contract;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ContractController implements ControllerUtils<Contract> {

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

    @Override
        public Object[][] convertListToArray(List<Contract> contracts) {
            Object[][] data = new Object[contracts.size()][10];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

            for (int i = 0; i < contracts.size(); i++) {
                Contract contract = contracts.get(i);
                data[i][0] = contract.getTenantName();
                data[i][1] = contract.getnKitnet();
                data[i][2] = dateFormat.format(contract.getStartDate());
                data[i][3] = dateFormat.format(contract.getEndDate());
                data[i][4] = contract.getRentAmount();
                data[i][5] = contract.getAdjustment();
                data[i][6] = contract.getStatus();
                data[i][7] = "Editar";
                data[i][8] = "Deletar";
            }
            return data;
        }
}
