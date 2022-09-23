trigger trgAccInsCon on Account (after insert) { 

    if (Trigger.isInsert) { 

        List<Contact> contacts = new List<Contact>(); 

        for (Account a : Trigger.new)  { 

            if(a.name == 'makeContact')  { 

                system.debug('Creating a contact recored for the account '+a.name); 

                contacts.add(new Contact (lastname = a.name, accountId = a.id));         

                //contacts.add(new Contact (lastname = a.name));         

            } 

        } 

        insert contacts; 

        system.debug('contacts--->'+contacts); 

    }     

} 