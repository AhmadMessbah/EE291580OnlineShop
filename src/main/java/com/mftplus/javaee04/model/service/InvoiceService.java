package com.mftplus.javaee04.model.service;

import com.mftplus.javaee04.model.entity.Invoice;
import com.mftplus.javaee04.model.repository.CrudRepository;
import com.mftplus.javaee04.model.service.impl.Service;

import java.util.List;

public class InvoiceService implements Service<Invoice,Long> {
    private static InvoiceService service = new InvoiceService();

    private InvoiceService() {
    }

    public  static InvoiceService getService() {
        return service;
    }

    @Override
    public Invoice save(Invoice invoice) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.save(invoice);
        }
    }

    @Override
    public Invoice edit(Invoice invoice) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.edit(invoice);
        }
    }

    @Override
    public Invoice remove(Long id) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.remove(Invoice.class, id);
        }
    }

    @Override
    public List<Invoice> findAll() throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.findAll(Invoice.class);
        }
    }

    @Override
    public Invoice findById(Long id) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.findById(Invoice.class, id);
        }
    }
}
