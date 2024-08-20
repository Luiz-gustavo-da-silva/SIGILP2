package br.ufrn.imd.Controllers;

import br.ufrn.imd.Models.Contract;
import br.ufrn.imd.Models.Kitnet;

import java.util.List;

public class ContractController {



    public List<Kitnet> searchKitchenettes(){
        Contract contract = new Contract();
        return contract.searchKitchenettes();
    }

}
