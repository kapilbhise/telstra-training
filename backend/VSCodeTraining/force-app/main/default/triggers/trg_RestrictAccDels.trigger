trigger trg_RestrictAccDels on Account (before delete) {  

  

    if (Trigger.isDelete && Trigger.isBefore) {  

  

    //In a before delete trigger, the trigger accesses the records that will be deleted with the Trigger.old list.  

  

        for (Account a : Trigger.old) {  

  

            if (a.name != 'okToDelete') {  

  

                system.debug('Record: '+a.name+' failed to delete');  

  

                a.addError('You can\'t delete this record!');  

  

                continue;  

  

            }  

  

            system.debug('Successfully Deleted Record: '+a.name);  

  

        }  

  

    }  

  

} 