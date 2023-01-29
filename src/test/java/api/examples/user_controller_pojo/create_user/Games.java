package api.examples.user_controller_pojo.create_user;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Games extends CreateUser{
    private String gameId;
    private String title;
    private String genre;
    private Boolean requiredAge;
    private Boolean isFree;
    private Float price;
    private String company;
    private String publish_date;
    private Integer rating;
    private String description;
    private String tags;
    private String dlcs;
    private String requirements;

    private Games(Builder builder) {
        this.gameId = builder.gameId;
        this.title = builder.title;
        this.genre = builder.genre;
        this.requiredAge = builder.requiredAge;
        this.isFree = builder.isFree;
        this.price = builder.price;
        this.company = builder.company;
        this.publish_date = builder.publish_date;
        this.rating = builder.rating;
        this.description = builder.description;
        this.tags = builder.tags;
        this.dlcs = builder.dlcs;
        this.requirements = builder.requirements;
    }

    public ArrayList<Games> setGame(Games gameInfo) {
        ArrayList<Games> game = new ArrayList<Games>();
        game.add(gameInfo);
        return game;
    }

    public static class Builder {
        private String gameId;
        private String title;
        private String genre;
        private Boolean requiredAge;
        private Boolean isFree;
        private Float price;
        private String company;
        private String publish_date;
        private Integer rating;
        private String description;
        private String tags;
        private String dlcs;
        private String requirements;

        public Builder gameId(String gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder requiredAge(Boolean requiredAge) {
            this.requiredAge = requiredAge;
            return this;
        }

        public Builder isFree(Boolean isFree) {
            this.isFree = isFree;
            return this;
        }

        public Builder price(Float price) {
            this.price = price;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder publish_date(String publish_date) {
            this.publish_date = publish_date;
            return this;
        }

        public Builder rating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder dlcs(String dlcs) {
            this.dlcs = dlcs;
            return this;
        }

        public Builder requirements(String requirements) {
            this.requirements = requirements;
            return this;
        }

        public Games build() {
            return new Games(this);
        }
    }
}


