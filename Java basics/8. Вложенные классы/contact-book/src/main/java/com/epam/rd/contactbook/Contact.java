package com.epam.rd.contactbook;

public class Contact {

    private String contactName;
    private int emailCapacity = 3;
    private int emailCounter = 0;
    private Email[] emails = new Email[emailCapacity];
    private ContactInfo phoneNumber;
    private int socialLinksCapacity = 5;
    private int socialLinksCounter = 0;
    private Social[] socialLinks = new Social[socialLinksCapacity];

    public Contact(String contactName) {
        this.contactName = contactName;
    }

    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {

        private String email;

        public Email(String localPart, String domain) {
            this.email = localPart + "@" + domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo {

        private String socialMediaLink;
        private String title;

        public Social(String title, String socialMediaLink) {
            this.title = title;
            this.socialMediaLink = socialMediaLink;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return socialMediaLink;
        }
    }

    public void rename(String newName) {
        if (newName != null && newName != "") {
            this.contactName = newName;
        }
    }

    private boolean canAddEmail() {
        return emailCounter < emailCapacity;
    }

    public Email addEmail(String localPart, String domain) {
        if (canAddEmail()) {
            Email newEmail = new Email(localPart, domain);
            emails[emailCounter] = newEmail;
            emailCounter++;
            return newEmail;
        }
        return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (canAddEmail()) {
            Email newEpamEmail = new Email(firstname + "_" + lastname, "epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            emails[emailCounter] = newEpamEmail;
            emailCounter++;
            return newEpamEmail;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (this.phoneNumber != null) {
            return null;
        }
        ContactInfo contactPhoneNumber = new ContactInfo() {
            private String telephoneNumber = "+" + code + " " + number;

            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return telephoneNumber;
            }
        };
        this.phoneNumber = contactPhoneNumber;
        return contactPhoneNumber;
    }

    private boolean canAddSocialLink() {
        return socialLinksCounter < socialLinksCapacity;
    }

    public Social addTwitter(String twitterId) {
        if (canAddSocialLink()) {
            Social newSocialLink = new Social("Twitter", twitterId);
            socialLinks[socialLinksCounter] = newSocialLink;
            socialLinksCounter++;
            return newSocialLink;
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        if (canAddSocialLink()) {
            Social newSocialLink = new Social("Instagram", instagramId);
            socialLinks[socialLinksCounter] = newSocialLink;
            socialLinksCounter++;
            return newSocialLink;
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        if (canAddSocialLink()) {
            Social newSocialLink = new Social(title, id);
            socialLinks[socialLinksCounter] = newSocialLink;
            socialLinksCounter++;
            return newSocialLink;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        int telephoneCounter = 0;
        if (this.phoneNumber != null) {
            telephoneCounter = 1;
        }

        ContactInfo contactInfo[] = new ContactInfo[1 + socialLinksCounter + emailCounter + telephoneCounter];
        contactInfo[0] = new NameContactInfo();

        int contactInfoCounter = 1;
        if (this.phoneNumber != null) {
            contactInfo[contactInfoCounter] = this.phoneNumber;
            contactInfoCounter++;
        }
        for (int i = 0; i < emailCounter; i++) {
            contactInfo[contactInfoCounter] = emails[i];
            contactInfoCounter++;
        }
        for (int i = 0; i < socialLinksCounter; i++) {
            contactInfo[contactInfoCounter] = socialLinks[i];
            contactInfoCounter++;
        }

        return contactInfo;
    }

}
