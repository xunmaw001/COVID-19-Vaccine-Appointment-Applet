const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmnw3e4/",
            name: "ssmnw3e4",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmnw3e4/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "新冠疫苗预约小程序"
        } 
    }
}
export default base
