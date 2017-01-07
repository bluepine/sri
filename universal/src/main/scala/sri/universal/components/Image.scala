package sri.universal.components

import chandu0101.macros.tojs.{JSMacro, exclude, rename}
import sri.core.{React, ReactNode}
import sri.universal.{ImageEvent, ReactEvent, ReactUniversal}
import sri.universal.apis.LayoutEvent

import scala.scalajs.js

case class Image(
                  source: js.UndefOr[ImageSource] = js.undefined,
                  @rename("source") sourceDynamic: js.UndefOr[js.Any] = js.undefined,
                  style: js.UndefOr[js.Any] = js.undefined,
                  onLayout: js.UndefOr[LayoutEvent => _] = js.undefined,
                  accessibilityLabel: js.UndefOr[String] = js.undefined,
                  onError: js.UndefOr[ReactEvent[ImageEvent] => _] = js.undefined,
                  ref: js.UndefOr[ImageM => _] = js.undefined,
                  onLoadEnd: js.UndefOr[ReactEvent[ImageEvent] => _] = js.undefined,
                  onLoad: js.UndefOr[ReactEvent[ImageEvent] => _] = js.undefined,
                  key: js.UndefOr[String] = js.undefined,
                  resizeMode: js.UndefOr[ImageResizeMode] = js.undefined,
                  testID: js.UndefOr[String] = js.undefined,
                  blurRadius: js.UndefOr[Double] = js.undefined,
                  onLoadStart: js.UndefOr[ReactEvent[ImageEvent] => _] = js.undefined,
                  defaultSource: js.UndefOr[ImageSource] = js.undefined,
                  @exclude animatedImage: Boolean = false,
                  @rename("defaultSource") defaultSourceDynamic: js.UndefOr[js.Dynamic] = js.undefined,
                  loadingIndicatorSrc: js.UndefOr[ImageSource] = js.undefined,
                  @rename("loadingIndicatorSrc") loadingIndicatorSrcDynamic: js.UndefOr[js.Dynamic] = js.undefined,
                  onProgress: js.UndefOr[ReactEvent[ImageEvent] => _] = js.undefined,
                  accessible: js.UndefOr[Boolean] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Image](this)
    val ctor = if (animatedImage) ReactUniversal.Animated.Image else ReactUniversal.Image
    React.createElement(ctor, props, children: _*)
  }

}

object Image {

  def getSize(uri: String, success: (Double, Double) => _, failure: js.Dynamic => _) = ReactUniversal.Image.asInstanceOf[js.Dynamic].getSize(uri, success, failure)

  def prefetch(url: String): js.Promise[js.Dynamic] = ReactUniversal.Image.asInstanceOf[js.Dynamic].prefetch(url).asInstanceOf[js.Promise[js.Dynamic]]
}


class ImageResizeMode private(val value: String) extends AnyVal


object ImageResizeMode {

  val COVER = new ImageResizeMode("cover")
  val CONTAIN = new ImageResizeMode("contain")
  val STRETCH = new ImageResizeMode("stretch")
  val REPEAT = new ImageResizeMode("repeat")
  val CENTER = new ImageResizeMode("center")

  def newMode(mode: String) = new ImageResizeMode(mode)

}

@js.native
trait ImageM extends js.Object