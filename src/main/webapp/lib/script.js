var inputForm = new Vue({
    el: "#profile-input",
    data: {
        profile: {
            name: {
                last: "",
                first: ""
            },
            type: "YOUTH",
            age: ""
        }
    },
    methods: {
        save: function() {
            var that = this;
            window.superagent
                .post("http://localhost:8080/JaxrsJson/api/profile/add")
                .send(that.profile)
                .set('Accept', 'application/json')
                .end(function(err, res) {
                    alert("保存が完了しました。")
                });
        }
    }
});

var profileSummary = new Vue({
    el: "#result",
    data: {
        load: false,
        result: {}
    },
    methods: {
        getResult: function() {
            this.load = true;
            var that = this;
            window.superagent
                .get("http://localhost:8080/JaxrsJson/api/profile/get")
                .end(function(err, res) {
                    that.$set("result", res.body);
                });
        }
    }
});