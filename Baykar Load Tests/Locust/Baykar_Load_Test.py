from locust import HttpUser, task, between

class BaykarKariyerUser(HttpUser):
    wait_time = between(1, 5)

    @task
    def load_homepage(self):
        self.client.get("/")

    @task
    def load_open_positions(self):
        self.client.get("/tr/basvuru/acik-pozisyonlar/")

    @task
    def load_high_altitude_program(self):
        self.client.get("/tr/yuksek-irtifa/")

    @task
    def load_campuses(self):
        self.client.get("/tr/yerleskelerimiz/")

    @task
    def load_social_areas(self):
        self.client.get("/tr/sosyal-alanlar/")

    @task
    def load_faq(self):
        self.client.get("/tr/sss/")

    @task
    def submit_contact_form(self):
        self.client.post("/tr/iletisim/", {
            "name": "Test User",
            "email": "testuser@example.com",
            "message": "Bu bir test mesajıdır."
        })

    @task
    def load_media_gallery(self):
        self.client.get("/tr/medya-galerisi/")

    @task
    def load_announcements(self):
        self.client.get("/tr/duyurular/")
