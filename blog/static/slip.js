// 滚动检测高度 并且更换header的颜色
import $ from 'jquery'

function handleScroll() {
  const scrollTop =
    document.documentElement.scrollTop || document.body.scrollTop;
  if (scrollTop > 360) {
    $(".head-container").css({ "color": "black", "background-color": "antiquewhite" });
    $(".head-container .left a").css("color", "black");
  } else {
    $(".head-container").css({ "color": "white", "background-color": "transparent" });
    $(".head-container .left a").css("color", "white");
  }
}


export default handleScroll