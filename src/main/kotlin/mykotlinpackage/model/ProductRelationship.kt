package mykotlinpackage.model


import com.github.manosbatsis.scrudbeans.api.domain.KPersistable
import com.github.manosbatsis.scrudbeans.api.mdd.annotation.model.ScrudBean
import com.github.manosbatsis.scrudbeans.validation.Unique
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 * Sample composite ID entity
 */
@Entity
@Unique
@Table(name = "product_relationships")
@ScrudBean
//@ApiModel(value = "Product Relationships", description = "A model representing a relationship between products")
data class ProductRelationship(

        @field:NotNull
       // @field:ApiModelProperty(required = true)
        @field:EmbeddedId
        override var id: ProductRelationshipIdentifier? = null,

        @field:NotNull
        @field:Column(nullable = false, length = 512)
       // @field:ApiModelProperty(value = "The relationship short description (max 512 chars)", required = true)
        var description: String? = null
) : KPersistable<ProductRelationshipIdentifier?> {
    override fun isNew(): Boolean = id == null
}