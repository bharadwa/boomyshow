

CREATE TABLE Users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       phoneNumber VARCHAR(20) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL
);

CREATE TABLE Cities (
                     id BIGINT AUTO_ICREMENT PRIMARY KEY,
                     name VARCHAR(100) NOT NULL
);
CREATE TABLE Theatres(
                         id BIGINT AUTO_ICREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         address VARCHAR(256) NOT NULL,
                         city_id BIGINT NOT NULL,
                         FOREIGN KEY (city_id) REFERENCES Cities(id),
                         INDEX idx_Theatres_city_id (city_id)
);

CREATE TABLE Features (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Screen (
                        id BIGINT AUTO_ICREMENT PRIMARY KEY,
                        theatre_id BIGINT NOT NULL,
                        FOREIGN KEY (theatre_id) REFERENCES Theatres (id),
                        INDEX idx_Theatres_city_id (city_id)
);

CREATE TABLE screen_features (
                                 screen_id BIGINT NOT NULL,
                                 feature_id INT NOT NULL,
                                 PRIMARY KEY (screen_id, feature_id),
                                 FOREIGN KEY (screen_id) REFERENCES Screen(id),
                                 FOREIGN KEY (feature_id) REFERENCES Features(id)
);

CREATE TABLE Seat_type (
                       id INT AUTO_ICREMENT PRIMARY KEY,
                       type VARCHAR(50) NOT NULL
);

CREATE TABLE Seats (
                    id BIGINT AUTO_ICREMENT PRIMARY KEY,
                    seatRow INT NOT NULL,
                    seatCol INT NOT NULL,
                    seatNumber VARCHAR (50) NOT NULL,
                    screen_id BIG NOT NULL,
                    seat_type_id INT NOT NULL,
                    FOREIGN KEY (seat_type_id) REFERENCES Seat_type(id),
                    FOREIGN KEY (screen_id)  REFERENCES  Screens(id),
                    INDEX idx_Seats_screen_id (screen_id)
);

CREATE TABLE Movies(
                       id INT AUTO_ICREMENT PRIMARY KEY,
                       name VARCHAR (256) NOT NULL,
                       description (256) NOT NULL,
                       duration TIME,
);

CREATE TABLE movie_features (
                                movie_id INT NOT NULL,
                                feature_id NOT NULL,
                                PRIMARY KEY (movie_id, feature_id),
                                FOREIGN KEY (movie_id) REFERENCES Movies(id),
                                FOREIGN KEY (feature_id) REFERENCES Features(id)
);

CREATE TABLE Actors (
                     id INT AUTO_ICREMENT PRIMARY KEY,
                     name VARCHAR (256) NOT NULL,
                     dob DATE
)

CREATE TABLE movies_actors (
                               movie_id INT NOT NULL,
                               actor_id INT NOT NULL,
                               PRIMARY KEY (movie_id, actor_id),
                               FOREIGN KEY (movie_id) REFERENCES Movies(id),
                               FOREIGN KEY (actor_id) REFERENCES Actors(id),
                               INDEX idx_movies_actors_movie_id (movie_id),
                               INDEX idx_movies_actors_actor_id (actor_id)
);

CREATE TABLE Shows (
                               id BIGINT AUTO_ICREMENT PRIMARY KEY,
                               movie_id INT NOT NULL,
                               screen_id BIGINT NOT NULL,
                               startTime DATE NOT NULL,
                               endTime DATE NOT NULL,
                               FOREIGN KEY (movie_id) REFERENCES Movies(id),
                               FOREIGN KEY (screen_id) REFERENCES Screens(id),
                               INDEX idx_Shows_movie_id (movie_id),
                               INDEX idx_Shows_screen_id (screen_id)
);

CREATE TABLE show_features (
                               show_id BIGINT NOT NULL,
                               feature_id INT NOT NULL ,
                               PRIMARY KEY (show_id, feature_id),
                               FOREIGN KEY (show_id) REFERENCES Shows(id),
                               FOREIGN KEY (feature_id) REFERENCES Features(id)
);

CREATE TABLE Show_Seat_Type (
                       show_id BIGINT NOT NULL,
                       seat_type_id INT NOT NULL,
                       prices DOUBLE NOT NULL,
                       PRIMARY KEY (show_id,seat_type_id),
                       FOREIGN KEY (show_id) REFERENCES  Shows(id),
                       FOREIGN KEY (seat_type_id) REFERENCES  Seat_type(id),
                       INDEX idx_Show_Seat_show_id(show_id)
);

CREATE TABLE Show_Seat(
                           id BIGINT AUTO_ICREMENT PRIMARY KEY,
                           show_id BIGINT NOT NULL,
                           seat_id BIGINT NOT NULL,
                           seatStatus ENUM('blocked','available','booked') NOT NULL,
                           FOREIGN KEY (show_id) REFERENCES  Shows(id),
                           FOREIGN KEY (seat_id) REFERENCES  Seats(id),
                           INDEX idx_Show_Seat_seat_id(seat_id),
                           INDEX idx_Show_Seat_show_id(show_id)
);

CREATE TABLE Bookings (
                          id BIGINT AUTO_ICREMENT PRIMARY KEY,
                          status ENUM  ('PENDING','CONFIRMED','CANCELLED','PENDING_PAYMENT','COMPLETED') NOT NULL,
                          movie_id INT NOT NULL,
                          user_id BIGINT NOT NULL,
                          dateOfBooking DATE NOT NULL
                          amount Double NOT NULL,
                          FOREIGN KEY (movie_id) REFERENCES  Movies(id),
                          FOREIGN KEY (user_id) REFERENCES  Users(id),
                          INDEX idx_Bookings_movie_id(movie_id),
                          INDEX idx_Bookings_user_id(user_id)
);

CREATE TABLE Show_Seat_Bookings (
                          booking_id BIGINT NOT NULL,
                          show_seat_id BIGINT NOT NULL,
                          PRIMARY KEY (booking_id,show_seat_id)
                          FOREIGN KEY (booking_id) REFERENCES  Bookings(id),
                          FOREIGN KEY (show_seat_id) REFERENCES  Show_Seat(id)
);

CREAT TABLE Payments (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      paymentProvider ENUM ('RAZORPAY','PAYU','CCAVENUE') NOT NULL,
                      paymentType ENUM ('COUPON','MONEY','REFUND','DISCOUNT') NOT NULL,
                      paymentStatus ENUM('SUCCESS','FAILED','PENDING') NOT NULL,
                      refId VARCHAR(100) NOT NULL,
                      amount Double NOT NULL,
                      date   DATE NOT NULL ,
                      booking_id BIGINT NOT NULL,
                      FOREIGN KEY (booking_id) REFERENCES  Bookings(id),
                      INDEX idx_Payments_booking_id(booking_id)
);


Cardinality of Relations:
Between  Bookings and Show_Seat --> m:m
Between  Bookings and Payments --> 1:m
Between  Bookings and Users -->m:1
Between  Show_Seat_Type and Shows --> m:1
Between  Show_Seat_Type and Seat_type -->m:1
Between  Show_Seat and Shows --> m:1
Between  Show_Seat and Seats -->m:1
Between  Theathre and Cities --> m:1
Between  Screen and Theathre -->m:1
Between Screen and Feature  --> m:m
Between Show and Feature  --> m:m
Between Movie and Feature  --> m:m
Between Seat and Seat_type -->m:1
Between Movies and Actors  -->m:m
Between Shows and Movies   -->m:1
Between Shows and Screen   -->m:1







