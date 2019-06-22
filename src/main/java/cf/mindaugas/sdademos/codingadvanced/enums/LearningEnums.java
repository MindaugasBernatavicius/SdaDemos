package cf.mindaugas.sdademos.codingadvanced.enums;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/*
Ref: https://www.baeldung.com/a-guide-to-java-enums
 */

class Pizza {

    // FIELDS
    private PizzaStatus status;

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    public enum PizzaStatus {
        ORDERED(30) {
            @Override
            public boolean isOrdered() {
                return true;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public boolean isDelivered() {
                return false;
            }
        },
        READY(10) {
            @Override
            public boolean isOrdered() {
                return true;
            }
            @Override
            public boolean isReady() {
                return true;
            }
            @Override
            public boolean isDelivered() {
                return false;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isOrdered() {
                return true;
            }
            @Override
            public boolean isReady() {
                return true;
            }
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    // LOGIC

    public String printTimeToDeliver() {
        return "Time to delivery is " + this.getStatus()
                .getTimeToDelivery();
    }

    public int getDeliveryTimeInMinutes() {
        switch (status) {
            case ORDERED: return 30;
            case READY: return 10;
            case DELIVERED: return 0;
        }
        return 0;
    }

    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY)
            return true;
        return false;
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> allPizzas) {
        return allPizzas.stream().filter((pizza) ->
                undeliveredPizzaStatuses.contains(pizza.getStatus()))
                .collect(Collectors.toList());
    }

    public static EnumMap<PizzaStatus, List<Pizza>> groupPizzaByStatus(List<Pizza> pizzaList) {
        EnumMap<PizzaStatus, List<Pizza>> pzByStatus =
                new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);

        for (Pizza pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<Pizza> newPzList = new ArrayList<>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }

    public void deliver() {
        if (isDeliverable()) {
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    // GETTERS / SETTERS

    public PizzaStatus getStatus() {
        return this.status;
    }

    public void setStatus(PizzaStatus st) {
        this.status = st;
    }
}

public class LearningEnums { }

