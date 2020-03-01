package mykotlinpackage.model

import com.github.manosbatsis.scrudbeans.api.domain.KPersistable
import com.github.manosbatsis.scrudbeans.api.mdd.annotation.model.ScrudBean
import com.github.manosbatsis.scrudbeans.validation.Unique
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull


/**
 * Sample entity model to test validation of non-null or unique @field:Column constraints
 */
@Entity
@Unique
@Table(name = "discount_code")
@ScrudBean
////@ApiModel(value = "DiscountCode", description = "A model representing an discount code")
data class DiscountCode(
        @field:Id
        @field:GeneratedValue(strategy = IDENTITY)
        override var id: Long? = null,

        @field:NotNull
        @field:Column(nullable = false, unique = true)
       // @field:ApiModelProperty(value = "The discount code", required = true)
        var code: String? = null,

        @field:NotNull
        @field:Column(nullable = false)
       // @field:ApiModelProperty(value = "The discount percentage", required = true)
        var percentage: Int? = null
) : KPersistable<Long> {
    override fun isNew(): Boolean = id == null
}