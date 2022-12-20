package vn.ansv.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.CurrencyUnit;
import vn.ansv.management.repositories.CurrencyUnitRepository;

@Service
public class CurrencyUnitService implements Interface_CurrencyUnit {
    @Autowired
    private CurrencyUnitRepository currencyUnitRepository;

    @Override
    public Iterable<CurrencyUnit> findAll() {
        return currencyUnitRepository.findAll();
    }
}
