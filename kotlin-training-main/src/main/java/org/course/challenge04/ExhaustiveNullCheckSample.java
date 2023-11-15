package org.course.challenge04;

public class ExhaustiveNullCheckSample {

    public String confirmationMessage(JAccount account, JBooking booking) {
        if (booking != null) {
            String amount = booking.getAmount() != null ? booking.getAmount().toString() : "FREE";
            if (booking.getDestination() != null && booking.getDestination().getHotel() != null) {
                JHotel hotel = booking.getDestination().getHotel();
                String stars = "";
                if (hotel.getStars() != null) {
                    stars = hotel.getStars();
                }
                String address = (hotel.getName() != null ? hotel.getName() : "") + " " + stars + "at " + (hotel.getAddress() != null ? hotel.getAddress() : "");
                if (account != null && account.getEmail() != null) {
                    return createMessage(account.getEmail(), amount, address);
                }
            }
        }
        return null;

    }

    private String createMessage(String email, String amount, String hotel) {
        return "Confirmation for: " + email + " amount: " + amount + " hotel: " + hotel;
    }


    class JAccount {
        private final String username;
        private final String email;

        JAccount(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }
    }

    class JBooking {
        private final Long amount;
        private final JDestination destination;


        public Long getAmount() {
            return amount;
        }

        public JDestination getDestination() {
            return destination;
        }


        JBooking(Long amount, JDestination destination) {
            this.amount = amount;
            this.destination = destination;
        }
    }

    class JDestination {
        private final String airport;
        private final JHotel hotel;

        JDestination(String airport, JHotel hotel) {
            this.airport = airport;
            this.hotel = hotel;
        }

        public String getAirport() {
            return airport;
        }

        public JHotel getHotel() {
            return hotel;
        }
    }

    class JHotel {
        private final String name;
        private final String address;
        private final String stars;

        JHotel(String name, String address, String stars) {
            this.name = name;
            this.address = address;
            this.stars = stars;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getStars() {
            return stars;
        }
    }


}
